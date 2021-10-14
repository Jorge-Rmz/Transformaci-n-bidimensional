# Transformacion-bidimensional
##  Transformación bidimensional con matrices
# Clase Figura
####  La clase Figura hereda de la clase JFrame, esta clase solo nos servirá para dibujar la figura con la que vamos a aplicar las trasformaciones geométricas. Tenemos la matriz con la que se dibuja en la figura, también tenemos las variables con la que vamos a estar trabajando así como también las funciones setter y getter de la matriz.

![FIGURA 1](https://user-images.githubusercontent.com/71052252/136890364-68f3a609-876a-4bb7-a25d-c72f623e3686.png)

#### En el constructor se muestra el código para llamar las diferentes clases y funciones para dibujar la figura, así como también se le da dimensiones a la ventana. 
![FIGURA 2](https://user-images.githubusercontent.com/71052252/136890367-b3f589ba-87ec-44b2-9d00-4c242c651221.png)

#### La función display de la clase GrapichListener se muestra el código para darle color a la figura posteriormente se dibuja la figura. 
![FIGURA 3](https://user-images.githubusercontent.com/71052252/136890368-b72cfb8e-3b57-4260-a721-8b2c782848fc.png)

#### En la función init se muestra el código donde se establecen los parámetros para la proyección
![FIGURA 4](https://user-images.githubusercontent.com/71052252/136890369-05707d13-e841-4735-8f62-12c7a854656f.png)

# Clase Trasformaciones

#### En esta clase se muestra todas las funciones para hacer las diferentes transformaciones a las figuras. Al principio están todas las variables utilizar al igual que el método main donde se muestran las invocaciones de las funciones que realizan cierta trasformación.
![FIGURA 5](https://user-images.githubusercontent.com/71052252/136890370-dcee83c1-e060-432f-b401-1413f0e2635b.png)

#### Función para trasponer una matriz.
![FIGURA 6](https://user-images.githubusercontent.com/71052252/136890371-639ae081-9ada-415c-a7cc-0de200886c5b.png)

#### Función para hacer la multiplicación de las matrices.
![FIGURA 7](https://user-images.githubusercontent.com/71052252/136890373-313fb5fc-e4d1-41ec-bcd2-f2cc378bd9ba.png)

#### Función para hacer el movimiento de trasladar para que la figura no se mueva su posición cuando se realiza la trasformación o rotación.
![FIGURA 8](https://user-images.githubusercontent.com/71052252/136890375-ab1115ae-bb6d-4a48-8cf3-39aa88866927.png)

#### En la función traslacion se utiliza para hacer las operaciones para hacer la traslación de nuestra figura, tenemos la matriz de traslación el cual se multiplicará por la matriz original, primero se traspone la matriz original para poder realizar la multiplicación de matrices y después se multiplica la matriz traslación por la matriz original.
![FIGURA 9](https://user-images.githubusercontent.com/71052252/136890377-d7b6f393-35f6-4d72-8598-1e3ea3163320.png)

#### En la función escalar servirá para realizar las operaciones de traslación a la figura primero se multiplica la matriz de escalamiento por la matriz original y posteriormente con if se verifica cual fue el eje que se movió y se realiza a trasladar la figura para que no se mueva de su eje.
![FIGURA 10](https://user-images.githubusercontent.com/71052252/136890378-03548a77-ea14-4ba3-99f4-92da5b279682.png)

#### En la función rotación se muestra las operaciones para rotar la figura, para realizar la rotación primero convertimos los grados a radianes, después se realizan las operaciones para calcular el valor de coseno, seno y seno negativo con respecto al ángulo a rotar; esos valores calculados se reemplazan en la matriz de rotación, para finalizar se realiza la multiplicación de las matrices y se realiza la traslación para que no se mueva del punto en x.
![FIGURA 11](https://user-images.githubusercontent.com/71052252/136890363-8948e673-88c3-472c-a462-f0622a979b4a.png)

# Ejecución del programa


