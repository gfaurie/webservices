package com.webservices.commands;

import java.util.Optional;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.webservices.datamodel.Project;


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
 *         &lt;element name="project" type="{http://spring.io/guides/gs-producing-web-service}project"/&gt;
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
    "project"
})
@XmlRootElement(name = "getProjectResponse")
public class GetProjectResponse {

    @XmlElement(required = true)
    protected Optional<Project> project;

    /**
     * Obtient la valeur de la propriété project.
     * 
     * @return
     *     possible object is
     *     {@link Project }
     *     
     */
    public Optional<Project> getProject() {
        return project;
    }

    /**
     * Définit la valeur de la propriété project.
     * 
     * @param optional
     *     allowed object is
     *     {@link Project }
     *     
     */
    public void setProject(Optional<Project> optional) {
        this.project = optional;
    }

}
