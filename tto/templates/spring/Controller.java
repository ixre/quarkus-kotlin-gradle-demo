/**
 * Copyright 2009-2019 @ to2.net
 * name : Controller.java
 * author : jarrysix (jarrysix#gmail.com)
 * date : 2019-07-14 07:47
 * description :
 * history :
 */
package com.tto.qkto.controllers;
#target!spring/src/main/java/{{.global.Pkg}}/controllers/{{.table.Title}}Controller.java
{{$pkField := lower_title .table.Pk}}
{{$pkType := type "java" .table.PkTypeId}}
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import {{pkg "java" .global.Pkg}}.service.{{.table.Title}}Service;
import {{pkg "java" .global.Pkg}}.pojo.{{.table.Title}}Entity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.line.arch.commons.std.http.HttpUtils;
import com.line.arch.commons.std.Result;
import com.line.arch.commons.std.TypesConv;
import com.line.arch.commons.std.Types;
import com.line.arch.commons.std.Typed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin/{{.table.Prefix}}")
public class {{.table.Title}}Controller {
    @Autowired private {{.table.Title}}Service service;

    /** {{.table.Comment}}列表 */
    @GetMapping("/{{lower_title .table.Title}}List")
    public String list(Model m){
        m.addAttribute("Where","");
        return "admin/{{.table.Prefix}}/{{.table.Name}}_list";
    }

    /** 修改{{.table.Comment}} */
    @GetMapping("/edit{{.table.Title}}")
    public String edit{{.table.Title}}({{$pkType}} {{.table.Pk}}, Model m){
        {{.table.Title}}Entity entity = this.service.findByIdOrNull(id);
        if(entity == null)return "admin/nodata";
        m.addAttribute("ID",id);
        m.addAttribute("Entity",entity);
        m.addAttribute("EntityJSON", Types.toJson(entity));
        return "admin/{{.table.Prefix}}/edit_{{.table.Name}}";
    }

    /** 保存{{.table.Comment}} */
    @PostMapping("/save{{.table.Title}}")
    @ResponseBody
    public Result save{{.table.Title}}(HttpServletRequest req) {
        {{.table.Title}}Entity entity = HttpUtils.mapEntity(req, {{.table.Title}}Entity.class);
        Error err = Typed.std.tryCatch(() -> {
            {{range $i,$c := .columns}}entity.set{{$c.Title}}(TypesConv.to{{title (type "java" $c.TypeId)}}(req.getParameter("{{$c.Name}}")));
            {{end}}
            this.service.save{{.table.Title}}(entity);
            return null;
        }).error();
        if(err != null){
            return Result.create(1,err.getMessage());
        }
        return Result.success(null);
    }

    /** {{.table.Comment}}详情 */
    @GetMapping("/{{lower_title .table.Title}}Details")
    public String orderDetails(HttpServletRequest req, HttpServletResponse rsp,Model m){
        {{$pkType}} {{$pkField}} = TypesConv.to{{title (type "java" .table.PkTypeId)}}(req.getParameter("{{$pkField}}"));
        {{.table.Title}}Entity entity = this.service.findByIdOrNull({{$pkField}});
        if(entity == null) {
            rsp.setStatus(404);
            return "";
        }
        m.addAttribute("Entity",entity);
        m.addAttribute("EntityJSON", Types.toJson(entity));
        return "admin/{{.table.Prefix}}/{{.table.Name}}_details";
    }
}
