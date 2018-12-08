# IntaSalle

## Argumentos

El primer parametro indica que archivo queremos leer.

  - xs_dataset.json
  - s_dataset.json
  - m_dataset.json
  - personalizado.json


El segundo parametro indica con que metodo de ordenamiento quieres ordenarlo, seguimos el siguiente orden.

  1. Merge Sort
  2. Quick Sort
  3. Selection Sort
  4. Radix Sort

El tercer parametro indica porque queremos ordenar
  
  1. Publicaciones
  2. Localizacion
      - En este caso el programa espera que se introduzca dos parametro a mayores
        - Latitud
        - Longitud
  3. Combinacion de prioridades
      - En este caso el programa espera que se introduzca un parametro a mayores
        - Numero de usuario sin user
        
        
### Ejemplo de Argumentos

1. Radix Combinacion de prioridades con el usuario 14

    ejemplo.json 4 3 14
    
2. Merge Localizacion con localizacion 41.2546 2.5588

    ejemplo.json 1 2 41.2546 2.5588
