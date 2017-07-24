package br.com.muxi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Titulo extends BasicEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer logic;
	
	@NotBlank(message="Serial não pode ser vazio.")
	private String serial;
	
	@NotBlank(message="Model não pode ser vazio.")
	private String model;

	@Min(value = 0, message = "Valor do campo sam não pode ser menor que zero.")
	private Integer sam;
	
	private String ptid;
	
	private Integer plat;
	
	@NotBlank(message="Version não pode ser vazio.")
	private String version;
	
	private Integer mxr;
	
	private Integer mxf;
	
	private String VERFM;

	public Integer getLogic() {
		return logic;
	}

	public void setLogic(Integer logic) {
		this.logic = logic;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getSam() {
		return sam;
	}

	public void setSam(Integer sam) {
		this.sam = sam;
	}

	public String getPtid() {
		return ptid;
	}

	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	public Integer getPlat() {
		return plat;
	}

	public void setPlat(Integer plat) {
		this.plat = plat;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getMxr() {
		return mxr;
	}

	public void setMxr(Integer mxr) {
		this.mxr = mxr;
	}

	public Integer getMxf() {
		return mxf;
	}

	public void setMxf(Integer mxf) {
		this.mxf = mxf;
	}

	public String getVERFM() {
		return VERFM;
	}

	public void setVERFM(String vERFM) {
		VERFM = vERFM;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((VERFM == null) ? 0 : VERFM.hashCode());
		result = prime * result + ((logic == null) ? 0 : logic.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((mxf == null) ? 0 : mxf.hashCode());
		result = prime * result + ((mxr == null) ? 0 : mxr.hashCode());
		result = prime * result + ((plat == null) ? 0 : plat.hashCode());
		result = prime * result + ((ptid == null) ? 0 : ptid.hashCode());
		result = prime * result + ((sam == null) ? 0 : sam.hashCode());
		result = prime * result + ((serial == null) ? 0 : serial.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titulo other = (Titulo) obj;
		if (VERFM == null) {
			if (other.VERFM != null)
				return false;
		} else if (!VERFM.equals(other.VERFM))
			return false;
		if (logic == null) {
			if (other.logic != null)
				return false;
		} else if (!logic.equals(other.logic))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (mxf == null) {
			if (other.mxf != null)
				return false;
		} else if (!mxf.equals(other.mxf))
			return false;
		if (mxr == null) {
			if (other.mxr != null)
				return false;
		} else if (!mxr.equals(other.mxr))
			return false;
		if (plat == null) {
			if (other.plat != null)
				return false;
		} else if (!plat.equals(other.plat))
			return false;
		if (ptid == null) {
			if (other.ptid != null)
				return false;
		} else if (!ptid.equals(other.ptid))
			return false;
		if (sam == null) {
			if (other.sam != null)
				return false;
		} else if (!sam.equals(other.sam))
			return false;
		if (serial == null) {
			if (other.serial != null)
				return false;
		} else if (!serial.equals(other.serial))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Titulo [logic=" + logic + ", serial=" + serial + ", model=" + model + ", sam=" + sam + ", ptid=" + ptid
				+ ", plat=" + plat + ", version=" + version + ", mxr=" + mxr + ", mxf=" + mxf + ", VERFM=" + VERFM
				+ "]";
	}

}
