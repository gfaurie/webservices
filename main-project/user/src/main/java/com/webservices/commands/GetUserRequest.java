package com.webservices.commands;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idUser" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pwd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="is_manager" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="managerId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idUser",
    "login",
    "pwd",
    "name",
    "lname",
    "is_manager",
    "managerId"
})
@XmlRootElement(name = "getUserRequest")
public class GetUserRequest {

    @XmlElement(required = true)
    protected int idUser;
    @XmlElement(required = true)
    protected String login;
    @XmlElement(required = true)
    protected String pwd;
    protected String name;
    protected String lname;
    protected boolean is_manager;
    protected int managerId;

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété prenom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLName() {
        return lname;
    }

    /**
     * Définit la valeur de la propriété prenom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLName(String value) {
        this.lname = value;
    }

    /**
     * Obtient la valeur de la propriété id_user.
     * 
     */
    public Long getIdUser() {
        return (long) idUser;
    }

    /**
     * Définit la valeur de la propriété id_user.
     * 
     */
    public void setIdUser(int value) {
        this.idUser = value;
    }

    /**
     * Obtient la valeur de la propriété login.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Définit la valeur de la propriété login.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Obtient la valeur de la propriété password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Définit la valeur de la propriété password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwd(String value) {
        this.pwd = value;
    }
    
    /**
     * Obtient la valeur de la propriété is_manager.
     * 
     * @return
     *     possible object is
     *     {@link boolean }
     *     
     */
    public boolean getIsMgr() {
        return is_manager;
    }

    /**
     * Définit la valeur de la propriété is_manager.
     * 
     * @param value
     *     allowed object is
     *     {@link boolean }
     *     
     */
    public void setIsMgr(boolean value) {
        this.is_manager = value;
    }
    
    /**
     * Obtient la valeur de la propriété id_manager.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
    public int getIdMgr() {
        return managerId;
    }

    /**
     * Définit la valeur de la propriété id_manager.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
    public void setIdMgr(int value) {
        this.managerId = value;
    }
}
