package br.coop.unimed.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import br.coop.unimed.constants.ResultadoBuscaMavenPortletKeys;

/**
 * @author marco.filho
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.Testes",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ResultadoBuscaMaven", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ResultadoBuscaMavenPortletKeys.RESULTADOBUSCAMAVEN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ResultadoBuscaMavenPortlet extends MVCPortlet {

	public static final String PARAM_TERMO = "q";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(httpRequest);

		String queryString = request.getParameter(PARAM_TERMO);
		System.out.println(queryString);

		request.setAttribute("queryString", queryString);

		super.doView(renderRequest, renderResponse);
	}

}