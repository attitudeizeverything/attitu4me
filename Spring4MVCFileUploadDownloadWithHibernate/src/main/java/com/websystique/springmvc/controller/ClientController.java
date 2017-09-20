package com.websystique.springmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.model.AppResponse;
import com.websystique.springmvc.model.CampaignContents;
import com.websystique.springmvc.model.CampaignResponse;
import com.websystique.springmvc.model.ContentPlayingNow;
import com.websystique.springmvc.model.ContentRequest;
import com.websystique.springmvc.model.Device;
import com.websystique.springmvc.model.DeviceCategory;
import com.websystique.springmvc.model.DeviceLocation;
import com.websystique.springmvc.model.PriceRequest;
import com.websystique.springmvc.model.UserDocument;
import com.websystique.springmvc.service.ContentPlayingNowService;
import com.websystique.springmvc.service.DeviceCategoryService;
import com.websystique.springmvc.service.DeviceLocationService;
import com.websystique.springmvc.service.DeviceService;
import com.websystique.springmvc.service.PlayingPriceService;
import com.websystique.springmvc.service.UserDocumentService;
import com.websystique.springmvc.util.EncryptUtils;

@RestController
public class ClientController {

	@Autowired
	ContentPlayingNowService contentPlayingNowService;
	
	@Autowired
	DeviceService deviceService;
	
	@Autowired
	DeviceLocationService deviceLocationService;
	
	@Autowired
	UserDocumentService userDocumentService;
	
	@Autowired
	PlayingPriceService playingPriceService;
	
	@Autowired
	DeviceCategoryService deviceCategoryService;
	
	@RequestMapping(value = "/ads", method = RequestMethod.POST,headers="Accept=application/json")
	public AppResponse getFile(@RequestParam (name="id") String id){
		List<ContentPlayingNow> cont = contentPlayingNowService.findByDeviceId(Integer.parseInt(id));
		for (ContentPlayingNow contentPlayingNow : cont) {
		System.out.println(contentPlayingNow.getUserDocument().getPlayGroup());
		}
		
		AppResponse response = new AppResponse();
		
		ArrayList<CampaignResponse> campresponse = new ArrayList<CampaignResponse>(); 
				
		for(int i=0;i<cont.size();i++){
			
			CampaignResponse res= new CampaignResponse();
			res.setDelay(cont.get(i).getDelay());
			res.setStartDateTime(cont.get(i).getStartTime());
			res.setEndDateTime(cont.get(i).getEndTime());
			res.setUnit(cont.get(i).getDelayUnit());
			CampaignContents campaignContents = new CampaignContents();
			List<CampaignContents> campaignContents2 = new ArrayList<CampaignContents>();
			campaignContents.setImageDetails(cont.get(i).getUserDocument().getFileLocation());
			campaignContents.setUnqiqueIdentifier(cont.get(i).getUserDocument().getUniqueIdentifier());
			campaignContents2.add(campaignContents);
			res.setCampaignContents(campaignContents2);
			//if(cont.get(i).getUserDocument().getPlayGroup())
			campresponse.add(res);
		}
		
		 response.setResponse(campresponse);
		 return response;
	}
	
	@RequestMapping(value = "/devices", method = RequestMethod.POST,headers="Accept=application/json")
	public List<Device> getAllDevices(@RequestParam (name="deviceLocationId") String deviceLocationId){
		return deviceService.getDevicesByLocation(Integer.parseInt(deviceLocationId));
	}
	
	@RequestMapping(value = "/deviceLocation", method = RequestMethod.POST,headers="Accept=application/json")
	public List<DeviceLocation> getAllDevicesInCity(@RequestParam (name="cityName") String cityName){
		return deviceLocationService.getLocationByCity(cityName);
	}
	
	@RequestMapping(value = "/saveContents", method = RequestMethod.POST,headers="Accept=application/json")
	public String saveContent(@RequestBody ContentRequest contentRequest){
		 saveContents(contentRequest);
		 return "Campaign Details Saved Succeffully!!";
	}
	
	@RequestMapping(value = "/price", method = RequestMethod.POST,headers="Accept=application/json")
	public Double getPrice(@RequestBody PriceRequest priceRequest){
		List<Device> category= deviceService.getPrice(priceRequest.getDeviceId()); 
		double price =0.0d;
		System.out.println(category.size());
		for (Device device : category) {
			  price+=device.getDeviceCategory().getNumberOffTimesPlayed() * device.getDeviceCategory().getSecondsPlayed() * device.getDeviceCategory().getPrice();
		}
		return price*getWorkingDaysBetween(priceRequest.getStartDate(), priceRequest.getEndDate());
	}
	
	private void saveContents(ContentRequest contentRequest){
		ContentPlayingNow now ;
		for (Integer deviceId : contentRequest.getDeviceId()) {
			now = new ContentPlayingNow();
			Device device = deviceService.findDeviceById(deviceId);
			UserDocument document = userDocumentService.findById(contentRequest.getContnetId());
			now.setDelay(slotBetweenCampaign(device.getDeviceCategory()));
			now.setDelayUnit("SEC");
			now.setDevice(device);
			now.setEndTime(contentRequest.getEndDate().toString());
			now.setStartTime(contentRequest.getStartDate().toString());
			now.setCampaignPrice(contentRequest.getPrice());
			now.setUserDocument(document);
			now.setIsActive(1);
			now.setIsDeleted(0);
			now.setGroupId(EncryptUtils.base64encode(contentRequest.getEndDate().toString()+contentRequest.getStartDate().toString()+document.getName()));
			contentPlayingNowService.save(now);
		}
	}
	
	private int getWorkingDaysBetween(Date startDate, Date endDate) {
	    int workingDays = 0;
	    try
	    {
	      Calendar start = Calendar.getInstance();
	      start.setTime(startDate);
	      Calendar end = Calendar.getInstance();
	      end.setTime(endDate);
	      
	      while(!start.after(end))
	      {
	        //int day = start.getDay();
	        int day = start.get(Calendar.DAY_OF_WEEK);
	        //if ((day != Calendar.SATURDAY) || (day != Calendar.SUNDAY)) if it's sunday, != to Saturday is true
	        if ((day != Calendar.SATURDAY) && (day != Calendar.SUNDAY))
	        workingDays++;
	        start.add(Calendar.DATE, 1);
	      }
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    return workingDays;
	}
	
	private int slotBetweenCampaign(DeviceCategory category){
		return (60/numberOfAdsPerDay(category))*60;
	}
	
	private int numberOfAdsPerDay(DeviceCategory category){
		int secPerDay=category.getHours()*60*60;
		return secPerDay/(category.getNumberOffTimesPlayed()*category.getSecondsPlayed());
	}
	
	private void setStartTime(DeviceCategory category){
		
	}
	
	private void getSlots(){
		
	}
}
