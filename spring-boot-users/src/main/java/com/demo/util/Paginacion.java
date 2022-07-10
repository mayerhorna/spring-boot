package com.demo.util;


public class Paginacion implements Constantes {
	private long numeroDePagina;
	private int registrosPorPagina;
	private int motorDeBD;
	private long numeroTotalDePaginas;
	
	private long numeroTotalRegistros;
		
	public long getNumeroTotalRegistros() {
		return numeroTotalRegistros;
	}

	public void setNumeroTotalRegistros(long numeroTotalRegistros) {
		this.numeroTotalRegistros = numeroTotalRegistros;
		long nroTotalRegistros = numeroTotalRegistros;
		long nroTotalPaginas = (long)Math.ceil((double)nroTotalRegistros / (double)this.getRegistrosPorPagina());
		this.setNumeroTotalDePaginas(nroTotalPaginas);
	}

	public Paginacion(){
		numeroDePagina = 1; 	// pagina por defecto
		registrosPorPagina = nroRegistrosXPagina;
		motorDeBD = DB_POSTGRES;//Conexion.obtenerMotorDeBDActual();
	}
	
	public Paginacion(int paramNroRegistrosXPagina){
		registrosPorPagina = paramNroRegistrosXPagina;
		motorDeBD = DB_POSTGRES;//Conexion.obtenerMotorDeBDActual();
	}
	
	public long getNumeroDePagina() {
		return numeroDePagina;
	}
	public void setNumeroDePagina(long numeroDePagina) {
		this.numeroDePagina = numeroDePagina;
	}
	public int getRegistrosPorPagina() {
		return registrosPorPagina;
	}
	public void setRegistrosPorPagina(int registrosPorPagina) {
		this.registrosPorPagina = registrosPorPagina;
	}
	
	public String obtenerSentencia(){
		String sentencia = "";
		if(motorDeBD == DB_MYSQL){
			long nroRegistroInicio = registrosPorPagina * (numeroDePagina - 1 );
			sentencia = "LIMIT " + nroRegistroInicio + " , " + registrosPorPagina + " "; 	 
		}else if (motorDeBD == DB_ORACLE){
			///
		}else if (motorDeBD == DB_POSTGRES){
			long nroRegistroInicio = registrosPorPagina * (numeroDePagina - 1 );
			sentencia = "LIMIT " + registrosPorPagina + " OFFSET " + nroRegistroInicio + " "; 	 
		}else if (motorDeBD == DB_MSSQL){
			
		}	
		return sentencia;
	}

	public long getNumeroTotalDePaginas() {
		return numeroTotalDePaginas;
	}

	public void setNumeroTotalDePaginas(long numeroTotalDePaginas) {
		this.numeroTotalDePaginas = numeroTotalDePaginas;
	}

	public void actualizarPaginaActual(String nroPaginaActual, String operacionPaginacion, String nroTotalPaginas) {
		long nroPaginaActualTmp = Long.valueOf(nroPaginaActual.trim());
		if(operacionPaginacion.equals(paginacion_primero)){			
			this.numeroDePagina = 1;
		}else if(operacionPaginacion.equals(paginacion_atras)){		
			this.numeroDePagina = nroPaginaActualTmp - 1;
		}else if(operacionPaginacion.equals(paginacion_siguiente)){
			this.numeroDePagina = nroPaginaActualTmp + 1;
		}else if(operacionPaginacion.equals(paginacion_ultimo)){
			this.numeroDePagina = Long.parseLong(nroTotalPaginas);
		}else{
			this.numeroDePagina = nroPaginaActualTmp;
		} 		
	}
	
	public String getStrRegistrosMostrados(){
		StringBuffer strBf = new StringBuffer();
		strBf.append("Registros Mostrados ");
		long nroRegistroEmpieza =  (this.nroRegistrosXPagina * (this.numeroDePagina - 1)) +1;
		long nroRegistroTermina ;
		if(this.numeroDePagina == this.numeroTotalDePaginas){
			nroRegistroTermina = this.numeroTotalRegistros;
		}else{
			nroRegistroTermina = nroRegistroEmpieza + this.getRegistrosPorPagina() - 1 ;
		}
		
		strBf.append(nroRegistroEmpieza);
		strBf.append(" - ");
		strBf.append(nroRegistroTermina);
		strBf.append(" de ");
		strBf.append(this.numeroTotalRegistros);
		return strBf.toString();
	}
	public int getStart() {
		return (int)(this.nroRegistrosXPagina * (this.numeroDePagina - 1)) +1;
	}

	
	
}
