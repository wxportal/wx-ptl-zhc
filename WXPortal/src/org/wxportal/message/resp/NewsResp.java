package org.wxportal.message.resp;

import java.util.List;

public class NewsResp extends AbstractBaseRespMessage {
	private int ArticleCount;
	private List<ArticleResp> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<ArticleResp> getArticles() {
		return Articles;
	}

	public void setArticles(List<ArticleResp> articles) {
		Articles = articles;
	}

	@Override
	public String handlerData2ReturnXml(List<Object> dbResultList) {
		// TODO Auto-generated method stub
		return null;
	}
}
