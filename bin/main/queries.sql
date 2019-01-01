
\c seniorproject

ALTER TABLE geolocation ADD COLUMN geom geometry(Point,4326);

INSERT INTO geolocation values ('1', true, 0, 0, ST_GeomFromText('POINT(35.1235 -119.3568)', 4326));

\! echo "By Radius:"
-- get only geolocation (use for testing)
-- SELECT * FROM geolocation
-- WHERE ST_DWithin(geom::geography, ST_GeogFromText('SRID=4326;Point(35 -119)'), 25.06*1609.344) --miles*meters = convert miles to meters
-- AND geolocation.is_shown_on_map=true;

-- build actual query here
-- SELECT gl.id, u.id, u.username, b.name FROM geolocation gl
-- INNER JOIN appuser u ON u.geolocation_id=gl.id
-- INNER JOIN business b ON u.id=b.owner_id
-- WHERE ST_DWithin(geom::geography, ST_GeogFromText('SRID=4326;Point(35 -119)'), 25.06*1609.344) --miles*meters = convert miles to meters
-- AND gl.is_shown_on_map=true;

-- CREATE OR REPLACE VIEW nearby_view AS
--   SELECT * FROM geolocation
--   WHERE ST_DWithin(geom::geography, ST_GeogFromText('SRID=4326;Point(35 -119)'), 25.06*1609.344) --miles*meters = convert miles to meters
--   AND geolocation.is_shown_on_map=true;


\! echo "All:"
SELECT * FROM geolocation;