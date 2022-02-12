-- USERS TABLE
INSERT INTO
    users (user_id, first_name, last_name, email, birthday, location, password)
VALUES
    (nextval('user_sequence'), 'Yassir', 'Douslimi', 'yassirdouslimi@gmail.com', current_timestamp, 'Kenitra', 'password'),
    (nextval('user_sequence'), 'Hicham', 'Talbi', 'hicham_talbi@gmail.com', current_timestamp, 'Casablanca', 'password'),
    (nextval('user_sequence'), 'Hanane', 'Mouhim', 'hanane_mouhim@gmail.com', current_timestamp, 'Casablanca', 'password'),
    (nextval('user_sequence'), 'Youssef', 'Sirajeddine', 'youssef_siraj@gmail.com', current_timestamp, 'Casablanca', 'password');

-- PROVIDER TABLE
INSERT INTO
    provider (provider_id, bio, user_id)
VALUES
    (2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultricies consequat eros id lobortis. Nam magna purus, fringilla sit amet tempus sit amet, faucibus in elit. Mauris iaculis, arcu dictum imperdiet molestie, risus libero blandit nisl, sed blandit libero neque quis ante. Morbi sit amet velit fringilla, ultrices sapien et, pharetra velit. Aliquam vitae eleifend neque.', 2),
    (3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultricies consequat eros id lobortis. Nam magna purus, fringilla sit amet tempus sit amet, faucibus in elit. Mauris iaculis, arcu dictum imperdiet molestie, risus libero blandit nisl, sed blandit libero neque quis ante. Morbi sit amet velit fringilla, ultrices sapien et, pharetra velit. Aliquam vitae eleifend neque.', 3),
    (4, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultricies consequat eros id lobortis. Nam magna purus, fringilla sit amet tempus sit amet, faucibus in elit. Mauris iaculis, arcu dictum imperdiet molestie, risus libero blandit nisl, sed blandit libero neque quis ante. Morbi sit amet velit fringilla, ultrices sapien et, pharetra velit. Aliquam vitae eleifend neque.', 4);
--
-- CUSTOMER TABLE
INSERT INTO
    customer (customer_id, user_id)
VALUES
    (1, 1);

-- DAYS TABLE
INSERT INTO
    days (day_id, name, provider_id)
VALUES
    (nextval('day_sequence'), 'Mon', 2),
    (nextval('day_sequence'), 'Tue', 2),
    (nextval('day_sequence'), 'Fri', 2),
    (nextval('day_sequence'), 'Tue', 3),
    (nextval('day_sequence'), 'Thu', 3),
    (nextval('day_sequence'), 'Wed', 4),
    (nextval('day_sequence'), 'Sat', 4),
    (nextval('day_sequence'), 'Sun', 4);

-- ICON TABLE
INSERT INTO
    icon (icon_id, icon_name)
VALUES
    (nextval('icon_sequence'), 'cable'),
    (nextval('icon_sequence'), 'hammer'),
    (nextval('icon_sequence'), 'box'),
    (nextval('icon_sequence'), 'fire'),
    (nextval('icon_sequence'), 'pen'),
    (nextval('icon_sequence'), 'terminal');

-- SKILL TABLE
INSERT INTO
    skill (skill_id, skill_name, icon_id, provider_id)
VALUES
    (nextval('skill_sequence'), 'name', 1, 2),
    (nextval('skill_sequence'), 'name', 2, 2),
    (nextval('skill_sequence'), 'name', 3, 2),
    (nextval('skill_sequence'), 'name', 4, 3),
    (nextval('skill_sequence'), 'name', 5, 3),
    (nextval('skill_sequence'), 'name', 6, 3),
    (nextval('skill_sequence'), 'name', 3, 4),
    (nextval('skill_sequence'), 'name', 5, 4),
    (nextval('skill_sequence'), 'name', 1, 4);

-- CATEGORY TABLE
INSERT INTO
    category (category_id, category_name)
VALUES
    (nextval('category_sequence'), 'Plumber'),
    (nextval('category_sequence'), 'Electrician'),
    (nextval('category_sequence'), 'Mechanic'),
    (nextval('category_sequence'), 'Tutor'),
    (nextval('category_sequence'), 'Cleaner'),
    (nextval('category_sequence'), 'Chef'),
    (nextval('category_sequence'), 'Other');

-- OFFER TABLE
INSERT INTO
    offer (offer_id, description, offer_name, price, rating, provider_id, icon_id, category_id)
VALUES
    (nextval('offer_sequence'), 'If your house has any plumbing issues, i will take care of them', 'Plumbing House', 200, 3, 2, 3, 1),
    (nextval('offer_sequence'), 'I will fix your car', 'Fixing Car', 136, 5, 3, 3, 3),
    (nextval('offer_sequence'), 'Cleaning bedrooms living room etc.', 'Clean House', 99, 4, 3, 3, 5),
    (nextval('offer_sequence'), 'Mow the lawn', 'Mow the lawn', 50, 2, 2, 3, 1),
    (nextval('offer_sequence'), 'Write a letter', 'Write a letter', 60, 5, 3, 3, 7),
    (nextval('offer_sequence'), 'Write a poem', 'Write poems', 60, 3, 2, 3, 7),
    (nextval('offer_sequence'), 'Cook for an occasion', 'Cook for an occasion', 200, 5, 4, 3, 6),
    (nextval('offer_sequence'), 'Fix ceiling', 'Fix ceiling', 163, 3, 4, 3, 7),
    (nextval('offer_sequence'), 'Change your tires', 'Change your tires', 60, 1, 2, 3, 3),
    (nextval('offer_sequence'), 'Teach you math', 'Teach you math', 80, 0, 4, 3, 4),
    (nextval('offer_sequence'), 'Paint your walls', 'Paint your walls', 130, 5, 4, 3, 7),
    (nextval('offer_sequence'), 'Take care of your kids', 'Take care of your kids', 100, 3, 2, 3, 7),
    (nextval('offer_sequence'), 'Drive you to a location', 'Drive you to a location', 40, 2, 3, 3, 7),
    (nextval('offer_sequence'), 'Deliver groceries to you house', 'Deliver groceries to you house', 30, 2, 3, 3, 6),
    (nextval('offer_sequence'), 'Fix broken sink', 'Fix broken sink', 80, 3, 4, 3, 1);

-- DETAIL TABLE
INSERT INTO
    detail (detail_id, content, offer_id)
VALUES
    (nextval('detail_sequence'), 'Plumbing license', 1),
    (nextval('detail_sequence'), 'I have my equipments', 1),
    (nextval('detail_sequence'), 'I can fix pretty much anything', 1);

-- JOB TABLE
INSERT INTO
    job (job_id, pending, rating, provider_id, offer_id, customer_id)
VALUES
    (nextval('job_sequence'), true, 0, 2, 11, 1);