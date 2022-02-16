# EJERCICIO 2

Escriba una aplicación browser que dada una URL lea datos de esa dirección y que los almacene en un archivo con el nombre resultado.html. Intente ver este archivo en el navegador. Su implementación debe ser un programa que reciba el parámetro de URL por medio de la línea de comandos.

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


1. Ubicarse en la carpeta 02-WebApp y borraremos todas las dependencias y modulos que puedan exisitir de los binarios del proyecto.
```maven
mvn clean
```

2. Realizamos la compilación del proyecto
```maven
mvn package
```

3. Ejecutamos el proyecto
```maven
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.URLReader" -Dexec.args="https://github.com/Rincon10/AREP-TALLER03"
```

<img src="https://github.com/Rincon10/AREP-TALLER03/blob/master/05-resources/img/02-mvnRunning.jpg" />

Creación de archivo html

<img src="https://github.com/Rincon10/AREP-TALLER03/blob/master/05-resources/img/02-html.jpg" />

Abriendo el html desde mi computador

<img src="https://github.com/Rincon10/AREP-TALLER03/blob/master/05-resources/img/02-resultadoHtml.jpg" />



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