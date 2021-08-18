package util;

import gest.Paciente;

public class Maxheap <T>{

		private ArrayDinamic<Integer> priori;
		private ArrayDinamic<T> guardar ;
		int size;
		
		public Maxheap(){
		this.priori= new ArrayDinamic<Integer>();
		this.guardar=new ArrayDinamic<T>();
		size=this.priori.size();
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
			if(this.priori.size()==this.size) {
				this.priori.pushback(p);
				this.guardar.pushback(key);
			}
			else {
				this.priori.set(this.size,p);
				this.guardar.set(this.size,key);
			}
			SiftUp(this.size);
			this.size=this.size+1;
		}
		
		
		public T ExtractMax() {
			T result = (T) this.guardar.get(0);
			if(this.size!=1) {
			this.priori.set(0,this.priori.get(this.size-1));
			this.guardar.set(0, this.guardar.get(this.size-1));
			this.size--;
			this.SiftDown(0);
			}
			else {
				this.priori= new ArrayDinamic<Integer>();
				this.guardar=new ArrayDinamic<T>();
				this.size--;
			}
			return result;
			
		}
		
		public int SearchIn (T key) {
			int n=-1;
			for (int i =0;i<this.size;i++) {
				if(this.guardar.get(i).equals(key)) {
					n=i;
					break;
				}
			}
			return n;
		}
		
		public T Remove(T key) {
			int n = SearchIn(key);
			try {
				return this.Removeaux(n);
				}
			catch(NullPointerException e) {
				return null;
			}
		}
		
		public T Removeaux(int i) {
			this.priori.set(i, (int) Double.POSITIVE_INFINITY);
			SiftUp(i);
			return ExtractMax();
		}
		
		public void ChangePriority(int p,T key) {
			int n = SearchIn(key);
			try {
				this.ChangePriorityaux(n,p,key);
				}
			catch(NullPointerException e) {
				System.out.print(" Objeto inexistente");
			}
		}		
		public void ChangePriorityaux(int i,int p, T key) {
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
		public int getSize() {
			return this.size;
		}
		public T getKey(int num) {
			return this.guardar.get(num);
		}
		public T getMax() {
			return this.guardar.get(0);
		}
	}
