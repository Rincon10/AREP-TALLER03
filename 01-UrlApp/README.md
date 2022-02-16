# EJERCICIO 1

Escriba un programa en el cual usted cree un objeto URL e imprima en pantalla cada uno de los componentes de una URL. Es decir , debe usar los siguientes métodos: getProtocol, getAuthority, getHost, getPort, getPath, getQuery, getFile, getRef. Asegúrese que ninguno imprima una cadena vacía, esto implica que la URL que use para su objeto debe contener datos suficientes.

## **Prerrequisitos**

-   [Git](https://git-scm.com/downloads) - Sistema de control de versiones
-   [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias
-   [Java 8](https://www.java.com/download/ie_manual.jsp) - Entorno de desarrollo
-   [Intellij Idea](https://www.jetbrains.com/es-es/idea/download/) (Opcional)

## **Instrucciones de ejecución local**

0. Desde cmd clonar el repositorio

```git
git clone https://github.com/Rincon10/AREP-TALLER03.git
```


1. Ubicarse en la carpeta 01-UrlApp y borraremos todas las dependencias y modulos que puedan exisitir de los binarios del proyecto.
```maven
mvn clean
```

2. Realizamos la compilación del proyecto
```maven
mvn package
```

3. Ejecutamos el proyecto
```maven
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.URLParser"
```

<img src="https://github.com/Rincon10/AREP-TALLER03/blob/master/05-resources/img/01-mvnRunning.jpg" />

4. Generando la documentación del proyecto
```mvn
mvn javadoc:javadoc
```
La documentación se generara en la ruta
```
target/site/apidocs/index.html
```

## **Construido con**
  -   [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias
  
  
## **Autor**

-   [Iván Camilo](https://github.com/Rincon10).