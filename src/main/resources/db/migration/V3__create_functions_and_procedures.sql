INSERT INTO moto VALUES (1, 'ABC1A23', 'Ativa', 1);
INSERT INTO moto VALUES (2, 'ABC1A24', 'Ativa', 2);
INSERT INTO moto VALUES (3, 'ABC1A25', 'Ativa', 3);
INSERT INTO moto VALUES (4, 'ABC1A26', 'Manutenção', 4);
INSERT INTO moto VALUES (5, 'ABC1A27', 'Ativa', 5);

INSERT INTO manutencao VALUES (1, SYSDATE, 'Troca de óleo', 4);

INSERT INTO setor VALUES (1, 'Entrada', 1);
INSERT INTO setor VALUES (2, 'Saída', 1);
INSERT INTO setor VALUES (3, 'Lavagem', 2);

INSERT INTO mapa_setor VALUES (1, 'Mapa Entrada', 1, 1);
INSERT INTO mapa_setor VALUES (2, 'Mapa Saída', 2, 1);
INSERT INTO mapa_setor VALUES (3, 'Mapa Lavagem', 3, 2);
