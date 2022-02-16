# EJERCICIO 3

Usando su  servidor y java (NO use frameworks web como Spark o Spring). Escriba un framework similar a Spark que le permita publicar servicios web "get" con funciones lambda y le permita acceder a recursoso estáticos como páginas, javascripts, imágenes, y CSSs. Cree una aplicación que conecte con una base de datos desde el servidor para probar su solución. Despliegue su solución en Heroku.

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


1. Ubicarse en la carpeta 04-Retos y borraremos todas las dependencias y modulos que puedan exisitir de los binarios del proyecto.
```maven
mvn clean
```

2. Realizamos la compilación del proyecto
```maven
mvn package
```

3. Ejecutamos el proyecto
```maven
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.server.NanoSparkServer"
```

<img src="https://github.com/Rincon10/AREP-TALLER03/blob/master/05-resources/img/04-mvnRunning.jpg" />

Ahora procederemos a probar nuestro nanoSpark por medio de diferentes peticiones

### Probando peticiones para archivos locales

#### img

<img src="https://github.com/Rincon10/AREP-TALLER03/blob/master/05-resources/img/05-img.jpg" />

#### css

<img src="https://github.com/Rincon10/AREP-TALLER03/blob/master/05-resources/img/05-css.jpg" />

#### js

<img src="https://github.com/Rincon10/AREP-TALLER03/blob/master/05-resources/img/05-js.jpg" />

#### html (not found)

<img src="https://github.com/Rincon10/AREP-TALLER03/blob/master/05-resources/img/05-notFound.jpg" />

### Recursos por defecto

<img src="https://github.com/Rincon10/AREP-TALLER03/blob/master/05-resources/img/05-defaultPage.jpg" />

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