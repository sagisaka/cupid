
//extractor = bmsys.extractor("5-gram");
extractor = bmsys.extractor(argv[4]);
sample = fs.open(argv[1]);
testcase = fs.open(argv[2]);
csv = argv[3];
p=extractor.extract(sample);
q=extractor.extract(testcase);
pair2 = bmsys.pairMaker("RoundRobin")
comparator = bmsys.comparator("JaccardIndex")
comparisons = comparator.compare(p,q, pair2);

comparisons.forEach(function(i){
	fs.add("" + i.left().className() + ",");
	fs.add("" + i.left().elementCount() + ",");
//	i.left().forEach(function(element){
//	fs.print("" + element + " ");
//	});
//	fs.print("" + ",");
	fs.add("" + i.right().className() + ",");
	fs.add("" + i.right().elementCount() + ",");
//	i.right().forEach(function(element){
//	fs.print("" + element +" ");
//	});
	// fs.print("" + ",");
	fs.add("" + i.similarity() + "\n");
	fs.writer(csv, "");
	//}
});
