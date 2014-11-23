package com.example.hakatonapp.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.hakatonapp.model.BasicFeedItem;
import com.example.hakatonapp.model.Profile;
import com.example.hakatonapp.model.TeachingFeedItem;

public class Parser {
	
	public static Profile parseProfile(String response)
	{
		JSONObject jObject = null;
		Profile profile = new Profile();
		
		if(response != null && response != "")
		{
			try {				
				jObject = new JSONObject(response);
				profile.setUserId(jObject.getString("profileid"));
				profile.setUsername(jObject.getString("username"));
				profile.setFirstName(jObject.getString("first_name"));
				profile.setLastName(jObject.getString("last_name"));
				profile.setPictureUrl(jObject.getString("picture"));
				profile.setPassword(jObject.getString("password"));
				
				JSONArray jInterested = null, jTeach = null;
				
				jInterested = jObject.getJSONArray("tags_interested");
				jTeach = jObject.getJSONArray("tags_teach");
				
				ArrayList<String> tagsTeach = new ArrayList<String>();
				ArrayList<String> tagsInterested = new ArrayList<String>();
				
				for(int i = 0; i < jInterested.length(); i++)
				{
					tagsInterested.add(jInterested.getString(i));
				}
				profile.setTagsInterested(tagsInterested);
				
				for(int i = 0; i< jInterested.length(); i++)
				{
					tagsTeach.add(jTeach.getString(i));
				}
				profile.setTagsInterested(tagsInterested);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return profile;
		}
		else
		{
			return null;
		}
	}
	
	public static BasicFeedItem parseBasicFeedItem(String response)
	{
		JSONObject jObject = null;
		BasicFeedItem basicFeedItem = new BasicFeedItem();
		
		if(response != null && response != "")
		{
			try {
				
				jObject = new JSONObject(response);
				basicFeedItem.setOwnerUsername("teacher");
				basicFeedItem.setTitle("theme");
				basicFeedItem.setDateAndTime(Date.valueOf("date_time"));
				
				JSONArray jTags = jObject.getJSONArray("tags");
				ArrayList<String> tags = new ArrayList<String>();
				for(int i = 0;i<jTags.length(); i++)
				{
					tags.add(jTags.getString(i));
				}
				basicFeedItem.setTags(tags);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return basicFeedItem;
		}
		else
		{
			return null;
		}
	}
	
	public static TeachingFeedItem parseTeachingFeedItem(String response)
	{
		JSONObject jObject = null;
		TeachingFeedItem teachingFeedItem = new TeachingFeedItem();
		
		if(response != null && response != "")
		{
			try {
				
				jObject = new JSONObject(response);
				
				teachingFeedItem.setBasicFeedItem(parseBasicFeedItem(response));
				teachingFeedItem.setMaxStudents(jObject.getInt("max_students"));
				
				JSONArray jStudentIds = jObject.getJSONArray("students");
				int[] studentIds = new int[jStudentIds.length()];
				for(int i = 0; i<jStudentIds.length(); i++)
				{
					studentIds[i] = jStudentIds.getInt(i);
				}
				teachingFeedItem.setStudentIds(studentIds);
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return teachingFeedItem;
		}
		else
		{
			return null;
		}
	}
	
	public static JSONObject createProfileJSON(Profile profile)
	{
		String tagsInterested = "[", tagsTeach = "[";
		HashMap map = new HashMap();
		
		map.put("password", profile.getPassword());
		map.put("first_name", profile.getFirstName());
		map.put("last_name", profile.getLastName());
		map.put("picture", profile.getPictureUrl());
		
		int i;
		for(i = 0 ; i < profile.getTagsInterested().size() - 1; i++)
		{
			tagsInterested += "\"" + profile.getTagsInterested().get(i) + "\", ";
		}
		i++;
		tagsInterested += "\"" + profile.getTagsInterested().get(i) + "\"]";
		
		
		for(i = 0 ; i < profile.getTagsTeach().size() - 1; i++)
		{
			tagsTeach += "\"" + profile.getTagsTeach().get(i) + "\", ";
		}
		i++;
		tagsTeach += "\"" + profile.getTagsTeach().get(i) + "\"]";
		
		map.put("tags_interested", tagsInterested);
		map.put("tags_teach", tagsTeach);
		
		return new JSONObject(map);
	}

}
