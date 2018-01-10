extractor = bmsys.extractor(argv[3]);
source = fs.open(argv[1]);
birthmarks = extractor.extract(source);
csv = argv[2];

fs.writer(csv, birthmarks);


