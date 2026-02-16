package com.example.helloworld.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		String userIp = extractClientIp(request);
		String userAgent = request.getHeader("User-Agent");
		String os = parseOperatingSystem(userAgent);
		String browser = parseBrowser(userAgent);

		return "Hello, " + userIp + "\n\nOperating System: " + os + "\nBrowser: " + browser;
	}

	private String extractClientIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip != null && !ip.isEmpty()) {
			// X-Forwarded-For can contain multiple IPs; the first is the client
			return ip.split(",")[0].trim();
		}
		ip = request.getHeader("X-Real-IP");
		if (ip != null && !ip.isEmpty()) {
			return ip;
		}
		return request.getRemoteAddr();
	}

	private String parseOperatingSystem(String userAgent) {
		if (userAgent == null) {
			return "Unknown";
		}
		if (userAgent.contains("Windows")) {
			return "Windows";
		}
		if (userAgent.contains("Mac OS X") || userAgent.contains("Macintosh")) {
			return "macOS";
		}
		if (userAgent.contains("Linux") && !userAgent.contains("Android")) {
			return "Linux";
		}
		if (userAgent.contains("Android")) {
			return "Android";
		}
		if (userAgent.contains("iPhone") || userAgent.contains("iPad") || userAgent.contains("iOS")) {
			return "iOS";
		}
		if (userAgent.contains("CrOS")) {
			return "ChromeOS";
		}
		return "Unknown";
	}

	private String parseBrowser(String userAgent) {
		if (userAgent == null) {
			return "Unknown";
		}
		// Order matters: check more specific identifiers first
		if (userAgent.contains("Edg/")) {
			return "Microsoft Edge";
		}
		if (userAgent.contains("OPR/") || userAgent.contains("Opera")) {
			return "Opera";
		}
		if (userAgent.contains("Chrome/") && !userAgent.contains("Chromium/")) {
			return "Chrome";
		}
		if (userAgent.contains("Safari/") && !userAgent.contains("Chrome/")) {
			return "Safari";
		}
		if (userAgent.contains("Firefox/")) {
			return "Firefox";
		}
		return "Unknown";
	}

}
