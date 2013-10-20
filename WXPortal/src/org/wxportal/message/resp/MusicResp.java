package org.wxportal.message.resp;

import java.util.List;

public class MusicResp extends AbstractBaseRespMessage {
	private String Title;
	private String Description;
	private String MusicUrl;
	private String HQMusicUrl;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String musicUrl) {
		HQMusicUrl = musicUrl;
	}

	@Override
	public String handlerData2ReturnXml(List<Object> dbResultList,
			AbstractBaseRespMessage response) {
		// TODO Auto-generated method stub
		return null;
	}
}