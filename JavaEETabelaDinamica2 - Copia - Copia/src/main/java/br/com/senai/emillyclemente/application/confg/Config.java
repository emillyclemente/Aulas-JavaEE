package br.com.senai.emillyclemente.application.confg;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
//As configurações para utilizar o JSF
@FacesConfig(version = Version.JSF_2_3)//É a versão do JSF
@ApplicationScoped//Quando carregar a aplicação, ela vai ser instanciada
public class Config {

}
 