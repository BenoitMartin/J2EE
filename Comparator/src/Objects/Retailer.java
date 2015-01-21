package Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity(name="Retailer")
@Table(name="Retailer")


public class Retailer {
		@Column(name="idRetailer",
            table="Retailer")
		@Id
		private int idRetailer;
		
		@Column(name="name",
	            table="Retailer")
		private String name;
		@Column(name="distance",
	            table="Retailer")
		private float distance;
		
		public Retailer(int id, String n, float dist){
			this.idRetailer=id;
			this.name=n;
			this.distance=dist;
					
		}

		/**
		 * @return the idRetailer
		 */
		public int getIdRetailer() {
			return idRetailer;
		}

		/**
		 * @param idRetailer the idRetailer to set
		 */
		public void setIdRetailer(int idRetailer) {
			this.idRetailer = idRetailer;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the distance
		 */
		public float getDistance() {
			return distance;
		}

		/**
		 * @param distance the distance to set
		 */
		public void setDistance(float distance) {
			this.distance = distance;
		}
		
	
		public String toString(){
			return "ID : "+this.getIdRetailer()+"\n Name : "+this.getName()+"\n Distance : "+this.getDistance();
		}
		
}
