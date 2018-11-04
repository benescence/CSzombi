package revivir.com.cementerio.persistencia.mysql;

import com.revivir.cementerio.persistencia.OBD;
import com.revivir.cementerio.persistencia.Obciso;
import com.revivir.cementerio.persistencia.interfaces.ObcisoOBD;

public class ObcisoOBDMySQL extends OBD implements ObcisoOBD{
	private final String campos = "DNI, apellido, nombre, fecha_fallecimiento, tipo_fallecimiento, cocheria";
	private final String tabla = "rev_obcisos";
	
	@Override
	public void insert(Obciso obciso) {
		String valores = "'"+obciso.getDni()+"'"
				+", '"+obciso.getApellido()+"'"
				+", '"+obciso.getNombre()+"'"
				+", '"+obciso.getFechaFallecimiento()+"'"
				+", "+obciso.getTipoFallecimiento()
				+", '"+obciso.getCocheria()+"'";
		String sql = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(sql);		
	}

}