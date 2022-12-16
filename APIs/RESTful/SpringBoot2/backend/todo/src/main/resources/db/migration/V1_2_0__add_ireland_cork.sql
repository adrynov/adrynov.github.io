insert into public.country (country_id, country, last_update)
values (353, 'Ireland', now())
ON CONFLICT DO NOTHING;

insert into public.city (city_id, city, country_id, last_update)
values (800, 'Cork', 353, now())
ON CONFLICT DO NOTHING;


insert into public.address (address_id, address, address2, district, city_id, postal_code, phone, last_update)
values (800, '11 Mourne Avenue', 'Dillons Cross', '', 800, 'T23V3F4', '086 3548205', now())
ON CONFLICT DO NOTHING;