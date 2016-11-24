package BattleShip;

import java.io.Serializable;

public class Coord implements Serializable{
		public int x,y;
		
		public Coord(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public static boolean coordonnees_valides(int x, int y){
			return ( (x<=9)&&(x>=0)&& (y<=9)&&(y>=0));
		}
		
		public boolean coordonnees_valides() {
			return this.x<=9 && this.x>=0 && this.y<=9 && this.y>=0;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			Coord other = (Coord) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "Coord [x=" + x + ", y=" + y + "]";
		}
}
