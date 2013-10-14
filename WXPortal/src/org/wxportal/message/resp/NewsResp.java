package org.wxportal.message.resp;

import java.util.List;
import java.util.Map;

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
	public String handlerData2ReturnXml(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}
}
