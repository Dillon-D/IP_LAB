
package dillon;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "anime1", targetNamespace = "http://dillon/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Anime1 {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://dillon/", className = "dillon.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://dillon/", className = "dillon.HelloResponse")
    @Action(input = "http://dillon/anime1/helloRequest", output = "http://dillon/anime1/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
