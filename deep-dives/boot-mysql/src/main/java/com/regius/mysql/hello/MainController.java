package com.regius.mysql.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/tenant")
public class MainController
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private transient final Logger logger = LoggerFactory.getLogger(getClass());
    
    @RequestMapping(method = RequestMethod.POST, value = "/{tenantName}")
    public @ResponseBody String newTenant(@PathVariable String tenantName)
    {
        logger.info("Creating tenant [{}]", tenantName);

        return tenantName;
    }

    @RequestMapping(method = RequestMethod.GET, value="/list")
    public @ResponseBody String list()
    {
        return "list me";
    }
}
