Algoritmo SumaDePares
	Definir n Como Entero
	Escribir "Ingrese un número entero positivo:"
	Leer n

	Si n > 0 Entonces
		CalcularYMostrarPares(n)
	Sino
		Escribir "Error: El número debe ser un entero positivo."
	FinSi
FinAlgoritmo

SubProceso CalcularYMostrarPares(limite)
	Definir i, suma Como Entero
	suma <- 0
	Escribir "los números pares son:"
	Para i <- 1 Hasta limite Hacer
		Si i MOD 2 = 0 Entonces
			Si suma = 0 Entonces
				Escribir Sin Saltar i
			Sino
				Escribir Sin Saltar "," i
			FinSi
			suma <- suma + i
		FinSi
	FinPara
	Escribir ""
	Escribir "Suma=" suma
FinSubProceso
