package com.ezdi.config;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by EZDI\ganesh.s on 14/7/16.
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=1800)
public class HttpSessionConfig {
}
