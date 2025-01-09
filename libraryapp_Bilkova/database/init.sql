CREATE TABLE book (
    name character varying(255) NOT NULL UNIQUE,
    author character varying(255) NOT NULL,
    pages int4 NOT NULL,
    available_copies int4 NOT NULL
);

INSERT INTO book (name, author, pages, available_copies) VALUES
('Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones', 'James Clear', 320, 2),
('Straight Shooter: A Memoir of Second Chances and First Takes', 'Stephen A. Smith', 288, 1),
('The Subtle Art of Not Giving a F*ck: A Counterintuitive Approach to Living a Good Life', 'Mark Manson', 224, 5),
('Rich Dad Poor Dad: What the Rich Teach Their Kids About Money That the Poor and Middle Class Do Not!', 'Robert T. Kiyosaki', 336, 3),
('Goodnight Moon', 'Margaret Wise Brown', 30, 10),
('The Four Agreements: A Practical Guide to Personal Freedom (A Toltec Wisdom Book)', 'Don Miguel Ruiz', 160, 2),
('Demon Copperhead: A Novel', 'Barbara Kingsolver', 560, 0),
('The Tools: 5 Tools to Help You Find Courage, Creativity, and Willpower--and Inspire You to Live Life in Forward Motion', 'Phil Stutz && Barry Michels', 288, 3),
('Tour of C++, A (C++ In-Depth Series)', 'Bjarne Stroustrup', 320, 15),
('Effective Java', 'Joshua Bloch', 416, 0),
('Clean Code: A Handbook of Agile Software Craftsmanship', 'Robert C. Martin', 464, 1);
