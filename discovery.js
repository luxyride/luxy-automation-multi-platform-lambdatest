const fs = require('fs');
const xml2js = require('xml2js');

// Read the XML file
const xmlFile = process.argv[2]; 
const xmlData = fs.readFileSync(xmlFile, 'utf8');

// Parse XML data
const parser = new xml2js.Parser({ explicitArray: false });

parser.parseStringPromise(xmlData).then((result) => {
    const suite = result.suite;
    const test = suite.test;
    const groups = test.groups.run.include; // Group includes
    const classes = test.classes.class; // All classes

    // Extract group names that are uncommented
    const uncommentedGroups = Array.isArray(groups) ? groups.map(group => group['$'].name) : [groups['$'].name];

    // Filter classes that belong to the uncommented groups
    const filteredClasses = classes.filter(cls => {
        const className = cls['$'].name;
        // Check if the class belongs to any uncommented group
        return uncommentedGroups.some(group => className.startsWith(group));
    });

    // Print filtered class names to the console
    const classNames = filteredClasses.map(cls => cls['$'].name);
    classNames.forEach(className => console.log(className));

}).catch((err) => {
    console.error('Error parsing XML:', err);
});
