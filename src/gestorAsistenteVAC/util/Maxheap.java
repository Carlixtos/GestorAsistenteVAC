package gestorAsistenteVAC.util;

public class Maxheap <T>{

		private ArrayDinamic<Integer> priori;
		private ArrayDinamic<T> guardar ;
		int size;
		int maxSize;
		
		public Maxheap(){
		this.priori= new ArrayDinamic<Integer>();
		this.guardar=new ArrayDinamic<T>();
		size=this.priori.size();
		maxSize=this.priori.capacity();
	}
		public int Parent(int i) {
			return (int) (Math.floor((i-1)/2));
		}
		public int LeftChild(int i) {
			return (2*i+1);
		}
		public int RightChild(int i) {
			return (2*i+2);
		}
		
		private void SiftUp(int i) {
			while (i>0 && (int)(this.priori.get(Parent(i)))<(int)(this.priori.get(i))) {
				int c = (int) (this.priori.get(Parent(i)));
				this.priori.set(Parent(i),this.priori.get(i));
				this.priori.set(i, c);
				T g = (T)(this.guardar.get(Parent(i)));
				this.guardar.set(Parent(i),this.guardar.get(i));
				this.guardar.set(i, g);
				i= Parent(i);			
			}
		}
		
		private void SiftDown(int i) {
			int maxIndex = i;
			int l=LeftChild(i);
			if (l <= this.size &&(int) this.priori.get(l)> (int)this.priori.get(maxIndex)) {
				maxIndex = l;
			}
			int r=RightChild(i);
			if (r<= this.size && (int)this.priori.get(r)>(int)this.priori.get(maxIndex)) {
				maxIndex = r;
			}
			if(i!= maxIndex) {
				int c = (int) (this.priori.get(i));
				this.priori.set((i),this.priori.get(maxIndex));
				this.priori.set(maxIndex, c);
				T g = (T)(this.guardar.get(i));
				this.guardar.set((i),this.guardar.get(maxIndex));
				this.guardar.set(maxIndex, g);
				SiftDown(maxIndex);
			}
		}
		
		public void Insert(int p, T key) {

			this.size=this.size+1;
			this.priori.set(this.size,p);
			this.guardar.set(this.size,key);
			SiftUp(this.size);
		}
		
		
		public T ExtractMax() {
			T result = (T) this.guardar.get(0);
			this.priori.set(0,this.priori.get(this.size));
			this.guardar.set(0, this.guardar.get(this.size));
			this.size--;
			SiftDown(0);
			return result;
			
		}
		
		public T Remove(int i) {
			this.priori.set(i, (int) Double.POSITIVE_INFINITY);
			SiftUp(i);
			return ExtractMax();
		}
		
		public void ChangePriority(int i,int p, T key) {
			int oldp =(int) this.priori.get(i);
			this.priori.set(i,p);
			//T oldkey =(T) this.guardar.get(i);
			this.guardar.set(i, key);
			if(p>oldp) {
				SiftUp(i);
			}
			else {
				SiftDown(i);
			}
			
			}
	}
