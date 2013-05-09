/**
 * create by :lixiaodong
 * create time:2013-1-11
 */
package com.jedisui.web;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jedisui.dao.JedisDao;
import com.jedisui.utils.DateUtils;

/**
 * @author lixiaodong
 * @time 下午2:31:44
 * @date 2013-1-11
 */
@Controller
public class JedisController {
	@Autowired
	private JedisDao jedisDao;
	
	public List<String> listAllKeys(){
		
		return null;
	}
	
	public Set<?> listMembers(String key){
		return null;
	}
	
	@RequestMapping("/searchJsonKeys")
	@ResponseBody
	public Set<String> searchJsonKeys(String pattern){
		return jedisDao.searchKeys(pattern);
	}
	
	@RequestMapping("/searchKeys")
	public String searchKeys(String pattern,Model model){
		Set<String> values = jedisDao.searchKeys("*"+pattern+"*");
		model.addAttribute("values",values);
		return "searchResult";
	}
	@RequestMapping("/get")
	public String get(String key,Model model){
		String value = jedisDao.get(key);
		long ttl = jedisDao.ttl(key);
		model.addAttribute("value",value);
		model.addAttribute("ttl",ttl);
		model.addAttribute("expireTime",DateUtils.formatYyyyMMdd(new Date(ttl)));
		return "value";
	}
	
	
}
