package ejercicio1;

public class TestEstudiante {

	public static void main(String[] args) {
		Estudiante[] array = new Estudiante[5];
		Estudiante estudiante1 = new Estudiante("Nombre1", "Apellido1", "Legajo1");
		Estudiante estudiante2 = new Estudiante("Nombre2", "Apellido2", "Legajo2");
		Estudiante estudiante3 = new Estudiante("Nombre3", "Apellido3", "Legajo3");
		Estudiante estudiante4 = new Estudiante("Nombre4", "Apellido4", "Legajo4");
		Estudiante estudiante5 = new Estudiante("Nombre5", "Apellido5", "Legajo5");
		array[0] = estudiante1;
		array[1] = estudiante2;
		array[2] = estudiante3;
		array[3] = estudiante4;
		array[4] = estudiante5;
		for (Estudiante estudiante : array) {
			System.out.println(estudiante);
		}
	}

}
