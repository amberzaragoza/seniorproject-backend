
\c seniorproject

-- ALTER TABLE geolocation ADD COLUMN geom geometry(Point,4326);

INSERT INTO geolocation values ('1233943', true, 0, 0, ST_GeomFromText('POINT(38.3778 -119.3568)', 4326));

SELECT * FROM geolocation
WHERE ST_DWithin(geom::geography, ST_GeogFromText('SRID=4326;Point(35 -119)'), 50000);