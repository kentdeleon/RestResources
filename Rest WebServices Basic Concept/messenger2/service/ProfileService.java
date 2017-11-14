package org.kent.restServices.messenger2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kent.restServices.messenger2.database.DatabaseClass;
import org.kent.restServices.messenger2.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("kent.deleon", new Profile(1,"kent.deleon", "Kent Louis", "De Leon"));
	}
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	private boolean findProfile(Profile profile) {
		return profiles.containsKey(profile.getProfileName());
	}
	public Profile addProfile(Profile profile) {
		if(findProfile(profile)) {
			return null;
		}
		profile.setId(profiles.size()+1);
		profile.setCreated();
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile updateProfile) {
		if(updateProfile.getProfileName().isEmpty()) {
			return null;
		}
		Profile oldProfile = profiles.get(updateProfile.getProfileName());
		updateProfile.setId(oldProfile.getId());
		profiles.put(updateProfile.getProfileName(), updateProfile);
		return updateProfile;
	}
	
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

}
