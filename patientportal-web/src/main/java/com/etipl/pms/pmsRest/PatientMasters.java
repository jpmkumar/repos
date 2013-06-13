package com.etipl.pms.pmsRest;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.etipl.pms.common.data.object.AbstractBaseObject;


	@XmlRootElement(name="patientMasters")
	@XmlAccessorType(XmlAccessType.FIELD)

	public class PatientMasters  extends AbstractBaseObject{

		@XmlElement(name="patientMaster")
		private Collection<PatientMaster> patientMaster;
		
		public PatientMasters()
		{
		
		}

		public Collection<PatientMaster> getPatientMaster() {
			return patientMaster;
		}

		public void setPatientMaster(Collection<PatientMaster> patientMaster) {
			this.patientMaster = patientMaster;
		}
		
		
	}
		