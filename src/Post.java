
public class Post {

	 public String Id;
	 public String postTypeId;
     public String ownerUserId;
     public String acceptedAnswerId;
     
     public Post(String postId,String type,String owner,String accpetedId){
    	 Id=postId;
    	 postTypeId=type;
    	 ownerUserId=owner;
    	 acceptedAnswerId=accpetedId;
     }
     public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPostTypeId() {
		return postTypeId;
	}

	public void setPostTypeId(String postTypeId) {
		this.postTypeId = postTypeId;
	}

	public String getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String getAcceptedAnswerId() {
		return acceptedAnswerId;
	}

	public void setAcceptedAnswerId(String acceptedAnswerId) {
		this.acceptedAnswerId = acceptedAnswerId;
	}
}
