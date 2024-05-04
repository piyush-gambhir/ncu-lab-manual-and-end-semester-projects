function calculate_dof_four_bar()
    % Take user inputs for number of links, joints, and higher pairs
    N_links = input('Enter the number of links in the four-bar mechanism: ');
    J_joints = input('Enter the number of revolute joints in the four-bar mechanism: ');
    H_pairs = input('Enter the number of higher pairs (if any) in the four-bar mechanism: ');

    % Gruebler's formula for degrees of freedom
    F = 3 * (N_links - 1) - 2 * J_joints - H_pairs;

    % Display degrees of freedom
    fprintf('Degrees of freedom for the four-bar mechanism: %d\n', F);
end

% Call the function to start the calculation
calculate_dof_four_bar();
