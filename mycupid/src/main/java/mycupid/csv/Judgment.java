package mycupid.csv;

public class Judgment {
	public Integer judgmentUc(int target_count,double simirality){
		Integer count =0;
		if(target_count>=5){
			if(simirality>=0.6 && simirality<0.75){
				count = 1;
				if(target_count>=27){
					count = 2;
				}
			}else if(simirality>=0.75 && simirality<0.9){
				count = 10;
				if(target_count>=27){
					count =20;
				}
			}else if(simirality>=0.9){
				count = 20;
				if(target_count>=27){
					count = 40;
				}
			}
		}
		return count;
	}
	public Integer judgmentTwo(int target_count,double simirality){
		Integer count =0;
		if(target_count>=105){
			if(simirality>=0.6 && simirality<0.75){
				count = 1;
				if(target_count>=2082){
					count = 2;
				}
			}else if(simirality>=0.75 && simirality<0.9){
				count = 10;
				if(target_count>=2082){
					count =20;
				}
			}else if(simirality>=0.9){
				count = 20;
				if(target_count>=2082){
					count = 40;
				}
			}
		}
		return count;
	}
	public Integer judgmentThree(int target_count,double simirality){
		Integer count =0;
		if(target_count>=97){
			if(simirality>=0.6 && simirality<0.75){
				count = 1;
				if(target_count>=2023){
					count = 2;
				}
			}else if(simirality>=0.75 && simirality<0.9){
				count = 10;
				if(target_count>=2023){
					count =20;
				}
			}else if(simirality>=0.9){
				count = 20;
				if(target_count>=2023){
					count = 40;
				}
			}
		}
		return count;
	}
	public Integer judgmentFour(int target_count,double simirality){
		Integer count =0;
		if(target_count>=87){
			if(simirality>=0.6 && simirality<0.75){
				count = 1;
				if(target_count>=1959){
					count = 2;
				}
			}else if(simirality>=0.75 && simirality<0.9){
				count = 10;
				if(target_count>=1959){
					count =20;
				}
			}else if(simirality>=0.9){
				count = 20;
				if(target_count>=1959){
					count = 40;
				}
			}
		}
		return count;
	}
	public Integer judgmentFive(int target_count,double simirality){
		Integer count =0;
		if(target_count>=80){
			if(simirality>=0.6 && simirality<0.75){
				count = 1;
				if(target_count>=1907){
					count = 2;
				}
			}else if(simirality>=0.75 && simirality<0.9){
				count = 10;
				if(target_count>=1907){
					count =20;
				}
			}else if(simirality>=0.9){
				count = 20;
				if(target_count>=1907){
					count = 40;
				}
			}
		}
		return count;
	}
}
