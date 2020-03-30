package org.joychou.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.beans.XMLDecoder;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;

@RestController
public class XmlDecoderRCE {

        /**
         * @author shadowsock5 @2020-03-16
         */
        @PostMapping("/XmlDecoder")
        public String parseXml(HttpServletRequest request) throws Exception{
            InputStream in = request.getInputStream();
            XMLDecoder d = new XMLDecoder(in);
            Object result = d.readObject(); //Deserialization happen here
            return "xstream";
        }
}
