package gt.edu.umes.proy.calculo;

public class LogicaDelNegocio {

    public long calcularSegundos(String[] argumentos) {
        if (argumentos.length != 5) {
            throw new IllegalArgumentException(
                "Debes ingresar exactamente 5 parametros."
            );
        }

        try {
            long meses = Long.parseLong(argumentos[0]);
            long semanas = Long.parseLong(argumentos[1]);
            long dias = Long.parseLong(argumentos[2]);
            long horas = Long.parseLong(argumentos[3]);
            long minutos = Long.parseLong(argumentos[4]);

            // Se considera un mes de 30 dias.
            long totalMinutos = Math.addExact(
                Math.addExact(
                    Math.addExact(
                        Math.multiplyExact(meses, 30L * 24 * 60),
                        Math.multiplyExact(semanas, 7L * 24 * 60)
                    ),
                    Math.multiplyExact(dias, 24L * 60)
                ),
                Math.addExact(
                    Math.multiplyExact(horas, 60L),
                    minutos
                )
            );

            return Math.multiplyExact(totalMinutos, 60L);
            
        //esta seccion de catch captura los errores

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "Todos los parametros deben ser numeros enteros."
            );
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(
                "El resultado excede el rango permitido."
            );
        }
    }
}