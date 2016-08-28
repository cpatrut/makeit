package ro.patrut.models.user.helper;

public enum UserProfileType {
	USER("USER"), DBA("DBA"), ADMIN("ADMIN");

	String userProfileType;

	private UserProfileType(String userProfileType) {
		this.userProfileType = userProfileType;
	}

	public String getUserProfileType() {
		return userProfileType;
	}
}
