package mycupid.csv;

public class Judgment {

	public Integer judgmentUc(int target_count,double simirality){
		Integer count =0;
		if(target_count>=3){
			if(simirality>=0.6 && simirality<0.75){
				//count = 1;
				if(target_count>=5 && target_count<10){
					//count = 2;
				}else if(target_count>=10 && target_count<27){
					count = 4;
				}else if(target_count>=27){
					count = 8;
				}
			}else if(simirality>=0.75 && simirality<0.9){
//				count = 2;
				if(target_count>=5 && target_count<10){
//					count = 4;
				}else if(target_count>=10 && target_count<27){
					count = 8;
				}else if(target_count>=27){
					count = 16;
				}
			}else if(simirality>=0.9){
//				count = 4;
				if(target_count>=5 && target_count<10){
//					count = 8;
				}else if(target_count>=10 && target_count<27){
					count = 16;
				}else if(target_count>=27){
					count = 32;
				}
			}
		}
		return count;
	}
	public Integer judgmentTwo(int target_count,double simirality){
		Integer count =0;
		if(target_count>=28){
			if(simirality>=0.6 && simirality<0.75){
//				count = 1;
				if(target_count>=105 && target_count<318){
//					count = 2;
				}else if(target_count>=318 && target_count<2082){
					count = 4;
				}else if(target_count>=2082){
					count = 8;
				}
			}else if(simirality>=0.75 && simirality<0.9){
//				count = 2;
				if(target_count>=105 && target_count<318){
//					count = 4;
				}else if(target_count>=318 && target_count<2082){
					count = 8;
				}else if(target_count>=2082){
					count = 16;
				}
			}else if(simirality>=0.9){
//				count = 4;
				if(target_count>=105 && target_count<318){
//					count = 8;
				}else if(target_count>=318 && target_count<2082){
					count = 16;
				}else if(target_count>=2082){
					count = 32;
				}
			}
		}
		return count;
	}
	public Integer judgmentThree(int target_count,double simirality){
		Integer count =0;
		if(target_count>=24){
			if(simirality>=0.6 && simirality<0.75){
//				count = 1;
				if(target_count>=97 && target_count<300){
//					count = 2;
				}else if(target_count>=300 && target_count<2023){
					count = 4;
				}else if(target_count>=2023){
					count = 8;
				}
			}else if(simirality>=0.75 && simirality<0.9){
//				count = 2;
				if(target_count>=97 && target_count<300){
//					count = 4;
				}else if(target_count>=300 && target_count<2023){
					count = 8;
				}else if(target_count>=2023){
					count = 16;
				}
			}else if(simirality>=0.9){
//				count = 4;
				if(target_count>=97 && target_count<300){
//					count = 8;
				}else if(target_count>=300 && target_count<2023){
					count = 16;
				}else if(target_count>=2023){
					count = 32;
				}
			}
		}
		return count;
	}
	public Integer judgmentFour(int target_count,double simirality){
		Integer count =0;
		if(target_count>=20){
			if(simirality>=0.6 && simirality<0.75){
//				count = 1;
				if(target_count>=87 && target_count<279){
//					count = 2;
				}else if(target_count>=279 && target_count<1959){
					count = 4;
				}else if(target_count>=1959){
					count = 8;
				}
			}else if(simirality>=0.75 && simirality<0.9){
//				count = 2;
				if(target_count>=87 && target_count<279){
//					count = 4;
				}else if(target_count>=279 && target_count<1959){
					count = 8;
				}else if(target_count>=1959){
					count = 16;
				}
			}else if(simirality>=0.9){
//				count = 4;
				if(target_count>=87 && target_count<279){
//					count = 8;
				}else if(target_count>=279 && target_count<1959){
					count = 16;
				}else if(target_count>=1959){
					count = 32;
				}
			}
		}
		return count;
	}
	public Integer judgmentFive(int target_count,double simirality){
		Integer count =0;
		if(target_count>=17){
			if(simirality>=0.6 && simirality<0.75){
//				count = 1;
				if(target_count>=80  && target_count<263){
//					count = 2;
				}else if(target_count>=263 && target_count<1907){
					count = 4;
				}else if(target_count>=1907){
					count = 8;
				}
			}else if(simirality>=0.75 && simirality<0.9){
//				count = 2;
				if(target_count>=80  && target_count<263){
//					count = 4;
				}else if(target_count>=263 && target_count<1907){
					count = 8;
				}else if(target_count>=1907){
					count = 16;
				}
			}else if(simirality>=0.9){
//				count = 4;
				if(target_count>=80  && target_count<263){
//					count = 8;
				}else if(target_count>=263 && target_count<1907){
					count = 16;
				}else if(target_count>=1907){
					count = 32;
				}
			}
		}
		return count;
	}


	public String rank(Integer count,Integer size){
		if(size*0.01*32+(size*0.1-size*0.01)*16<count){
			return "S";
		}else if((size*0.01*32+(size*0.1-size*0.01)*16)/2<count){
			return "A";
		}else if((size*0.01*32+(size*0.1-size*0.01)*16)/5<count){
			return "B";
		}else if((size*0.01*32+(size*0.1-size*0.01)*16)/10<count){
			return "C";
		}
		return "F";
	}


	//	if(target_count>=3){
	//		if(simirality>=0.6 && simirality<0.75){
	//			count = 1;
	//			if(target_count>=5 && target_count<10){
	//				count = 2;
	//			}else if(target_count>=10 && target_count<27){
	//				count = 4;
	//			}else if(target_count>=27){
	//				count = 8;
	//			}
	//		}else if(simirality>=0.75 && simirality<0.9){
	//			count = 2;
	//			if(target_count>=5 && target_count<10){
	//				count = 4;
	//			}else if(target_count>=10 && target_count<27){
	//				count = 8;
	//			}else if(target_count>=27){
	//				count = 16;
	//			}
	//		}else if(simirality>=0.9){
	//			count = 4;
	//			if(target_count>=5 && target_count<10){
	//				count = 8;
	//			}else if(target_count>=10 && target_count<27){
	//				count = 16;
	//			}else if(target_count>=27){
	//				count = 32;
	//			}
	//		}
	//	}
	//	return count;
	//}
	//public Integer judgmentTwo(int target_count,double simirality){
	//	Integer count =0;
	//	if(target_count>=28){
	//		if(simirality>=0.6 && simirality<0.75){
	//			count = 1;
	//			if(target_count>=105 && target_count<318){
	//				count = 2;
	//			}else if(target_count>=318 && target_count<2082){
	//				count = 4;
	//			}else if(target_count>=2082){
	//				count = 8;
	//			}
	//		}else if(simirality>=0.75 && simirality<0.9){
	//			count = 2;
	//			if(target_count>=105 && target_count<318){
	//				count = 4;
	//			}else if(target_count>=318 && target_count<2082){
	//				count = 8;
	//			}else if(target_count>=2082){
	//				count = 16;
	//			}
	//		}else if(simirality>=0.9){
	//			count = 4;
	//			if(target_count>=105 && target_count<318){
	//				count = 8;
	//			}else if(target_count>=318 && target_count<2082){
	//				count = 16;
	//			}else if(target_count>=2082){
	//				count = 32;
	//			}
	//		}
	//	}
	//	return count;
	//}
	//public Integer judgmentThree(int target_count,double simirality){
	//	Integer count =0;
	//	if(target_count>=24){
	//		if(simirality>=0.6 && simirality<0.75){
	//			count = 1;
	//			if(target_count>=97 && target_count<300){
	//				count = 2;
	//			}else if(target_count>=300 && target_count<2023){
	//				count = 4;
	//			}else if(target_count>=2023){
	//				count = 8;
	//			}
	//		}else if(simirality>=0.75 && simirality<0.9){
	//			count = 2;
	//			if(target_count>=97 && target_count<300){
	//				count = 4;
	//			}else if(target_count>=300 && target_count<2023){
	//				count = 8;
	//			}else if(target_count>=2023){
	//				count = 16;
	//			}
	//		}else if(simirality>=0.9){
	//			count = 4;
	//			if(target_count>=97 && target_count<300){
	//				count = 8;
	//			}else if(target_count>=300 && target_count<2023){
	//				count = 16;
	//			}else if(target_count>=2023){
	//				count = 32;
	//			}
	//		}
	//	}
	//	return count;
	//}
	//public Integer judgmentFour(int target_count,double simirality){
	//	Integer count =0;
	//	if(target_count>=20){
	//		if(simirality>=0.6 && simirality<0.75){
	//			count = 1;
	//			if(target_count>=87 && target_count<279){
	//				count = 2;
	//			}else if(target_count>=279 && target_count<1959){
	//				count = 4;
	//			}else if(target_count>=1959){
	//				count = 8;
	//			}
	//		}else if(simirality>=0.75 && simirality<0.9){
	//			count = 2;
	//			if(target_count>=87 && target_count<279){
	//				count = 4;
	//			}else if(target_count>=279 && target_count<1959){
	//				count = 8;
	//			}else if(target_count>=1959){
	//				count = 16;
	//			}
	//		}else if(simirality>=0.9){
	//			count = 4;
	//			if(target_count>=87 && target_count<279){
	//				count = 8;
	//			}else if(target_count>=279 && target_count<1959){
	//				count = 16;
	//			}else if(target_count>=1959){
	//				count = 32;
	//			}
	//		}
	//	}
	//	return count;
	//}
	//public Integer judgmentFive(int target_count,double simirality){
	//	Integer count =0;
	//	if(target_count>=17){
	//		if(simirality>=0.6 && simirality<0.75){
	//			count = 1;
	//			if(target_count>=80  && target_count<263){
	//				count = 2;
	//			}else if(target_count>=263 && target_count<1907){
	//				count = 4;
	//			}else if(target_count>=1907){
	//				count = 8;
	//			}
	//		}else if(simirality>=0.75 && simirality<0.9){
	//			count = 2;
	//			if(target_count>=80  && target_count<263){
	//				count = 4;
	//			}else if(target_count>=263 && target_count<1907){
	//				count = 8;
	//			}else if(target_count>=1907){
	//				count = 16;
	//			}
	//		}else if(simirality>=0.9){
	//			count = 4;
	//			if(target_count>=80  && target_count<263){
	//				count = 8;
	//			}else if(target_count>=263 && target_count<1907){
	//				count = 16;
	//			}else if(target_count>=1907){
	//				count = 32;
	//			}
	//		}
	//	}
	//	return count;
	//}
}
