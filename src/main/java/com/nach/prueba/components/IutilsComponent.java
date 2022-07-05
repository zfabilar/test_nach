package com.nach.prueba.components;

import java.sql.Date;

public interface IutilsComponent {
	/**
	 * Valida si la fecha ingresada es menor a la fecha del sistema
	 * @param fecha
	 * @return true si es menor, false si es mayor
	 */
	public boolean validaFecha(Date fecha);
	/**
	 * Compara una fecha de inicio con una de fin
	 * @param inicio
	 * @param Fin
	 * @return true si fecha inicial es menor, false si fecha fin es mayor
	 */
	public boolean comparaFechas(Date inicio,Date Fin);
	/**
	 * Le aumenta un dia al dia de la fecha, ya que por alguna razón se recibe con un dia menos
	 * @param fecha
	 * @return
	 */
	public Date aumentaDia(Date fecha);
}
