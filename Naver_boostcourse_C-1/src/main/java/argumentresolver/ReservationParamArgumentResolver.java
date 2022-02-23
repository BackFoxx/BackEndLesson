package argumentresolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ReservationParamArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType() == ReservationParam.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        int count = Integer.parseInt(webRequest.getParameter("int count"));
        int productPriceId = Integer.parseInt(webRequest.getParameter("int productPriceId"));
        int reservationInfoId = Integer.parseInt(webRequest.getParameter("int reservationInfoId"));
        int reservationInfoPriceId = Integer.parseInt(webRequest.getParameter("int reservationInfoPriceId"));
        ReservationPrice reservationPrice = new ReservationPrice(count, productPriceId, reservationInfoId, reservationInfoPriceId);

        int displayInfoId = Integer.parseInt(webRequest.getParameter("displayInfoId"));
        int productId = Integer.parseInt(webRequest.getParameter("productId"));
        String reservationEmail = webRequest.getParameter("reservationEmail");
        String reservationName = webRequest.getParameter("reservationName");
        String reservationTelephone = webRequest.getParameter("reservationTelephone");
        String reservationYearMonthDay = webRequest.getParameter("reservationYearMonthDay");

        return new ReservationParam(displayInfoId, reservationPrice, productId, reservationEmail, reservationName, reservationTelephone, reservationYearMonthDay);
    }
}
