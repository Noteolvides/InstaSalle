# IntaSalle

## IDE

Para poder compilar y ejecutar el proyecto, se tendrá que utilizar la IDE de jetBrains de IntelliJ Idea.
Una vez se ha abierto el proyecto con la IDE, si lo pide se tendrá que aceptar la conversion del proyecto a Maven 
y la descarga automática de las librerías.

Después de seguir estos pasos ya se podrá configura los diferentes argumentos para posteriormente compilarlo y ejecutarlo.
Para introducir los argumentos tendrás que dirigirte al botón del lado del "play" para compilar donde pone main. Allí seleccionaras "Edit Configurations...".

Esta opción te llevara a una ventana donde la casilla con el nombre de "Program Arguments:" es donde introducirás los argumentos con el formato siguiente.

## Argumentos

Los argumentos introducidos tienen que estar separados entre ellos por un espacio.

El primer parámetro indica que archivo queremos leer.

  - xs_dataset.json
  - s_dataset.json
  - m_dataset.json
  - personalizado.json
  
  *Los archivos de datasets deben estar dentro de la carpeta del proyecto del IDE.


El segundo parámetro indica con qué método de ordenamiento quieres ordenarlo, seguimos el siguiente orden.

  1. Merge Sort
  2. Quick Sort
  3. Selection Sort
  4. Radix Sort

El tercer parámetro indica porque queremos ordenar
  
  1. Publicaciones
  2. Localización
      - En este caso el programa espera que se introduzca dos parámetro a mayores
        - Latitud
        - Longitud
  3. Combinación de prioridades
      - En este caso el programa espera que se introduzca un parámetro a mayores
        - Numero de usuario sin user
        
        
### Ejemplo de Argumentos

1. Radix Combinación de prioridades con el user = "user14"

    ejemplo.json 4 3 14
    
2. Merge Localización con localización 41.2546 2.5588

    ejemplo.json 1 2 41.2546 2.5588
