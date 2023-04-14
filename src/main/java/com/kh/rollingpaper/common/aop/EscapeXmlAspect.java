package com.kh.rollingpaper.common.aop;

import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.kh.rollingpaper.board.model.dto.Board;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class EscapeXmlAspect {

	@Pointcut("execution(* com.kh.rollingpaper.board.controller.BoardController.boardList(..))")
	public void pointcut() {}
	
	@AfterReturning(pointcut = "pointcut()", returning = "returnObj")
	public void escapeXml(JoinPoint joinPoint, Object returnObj) {
		log.debug("returnObj = {}", returnObj);
		ModelAndView mav = (ModelAndView) returnObj;
		Map<String, Object> model = mav.getModel();
		List<Board> boardList = (List<Board>) model.get("boardList");
		
		for(Board board : boardList) {
			String maybeXss = board.getTitle();
			board.setTitle(escapeXml(maybeXss));
		}
	}

	private String escapeXml(String maybeXss) {
		return maybeXss.replaceAll("<", "&lt;")
						.replaceAll(">", "&gt");
	}
	
}
