Cómo usar este proyecto: 

-Fork del repositorio
-Clonar el repositorio
-Abrir proyecto android studio
-Hacer los cambios si se reuqieren
-Hacer un Pull Request
-Fork del repositorio

El primer paso es hacer "Fork" del repositorio.

Clonar el repositorio
Después de tener el repositorio en nuestra cuenta, seleccionar la dirección del repositorio "SSH o HTTP" y clonar:

$ git clone https://github.com/andresad13/prueba-Bold.git

Dentro de la carpeta que genera, comprobar la URL del repositorio:

$ git remote -v

abrir proyecto en android studio y hacer build

Antes de realizar modificaciones agregar la URL del repositorio original del proyecto:

$ git remote add upstream https://github.com/andresad13/prueba-Bold(Forkeado)

Comprobar

$ git remote -v

Agregar los archivos y hacer un commit

Después de realizar el commit hacer el push hacia nuestro repositorio indicando la rama que hemos creado.

$ git push origin feature-nombre-rama

Hacer un Pull Request
Hacer click en "Compare & Pull Request"

Escribir cambios del Pull Request.

Si todo está bien, enviar con el botón "Send Pull Request".

Esperar a que el duelo del repositorio lo revise, acepte y mezcle en la rama correspondiente.